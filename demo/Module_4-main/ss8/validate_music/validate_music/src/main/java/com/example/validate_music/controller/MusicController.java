package com.example.validate_music.controller;

import com.example.validate_music.dto.MusicDto;
import com.example.validate_music.model.Music;
import com.example.validate_music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping()
    public String showList(@PageableDefault(size = 3) Pageable pageable, Model model) {
        Page<Music> music = musicService.getList(pageable);
        model.addAttribute("music", music);
        return "list";
    }

    @GetMapping("/create")
    public String showFormAdd(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute MusicDto musicDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Music musicEntity = new Music();
        BeanUtils.copyProperties(musicDto, musicEntity);
        musicService.create(musicEntity);
        redirectAttributes.addFlashAttribute("message", "Tạo thành công");
        return "redirect:/music";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (musicService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Không tìm thấy đối tượng");
            return "redirect:/music";
        }
        Music music = musicService.findById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("musicDto", musicDto);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute MusicDto musicDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.update(music);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công");
        return "redirect:/music";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (musicService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Không tìm thấy đối tượng");
        } else {
            musicService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Xoá thành công");
        }
        return "redirect:/music";
    }
}

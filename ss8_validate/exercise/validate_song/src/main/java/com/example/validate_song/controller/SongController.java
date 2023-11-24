package com.example.validate_song.controller;

import com.example.validate_song.dto.SongDto;
import com.example.validate_song.model.Song;
import com.example.validate_song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showAllSong(@PageableDefault(size = 2) Pageable pageable, Model model) {
        model.addAttribute("songs", songService.getSongs(pageable));
        return "list";
    }

    @GetMapping("create")
    public String showFormCreate(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("create")
    public String addNewSong(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.create(song);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/song";
    }

    @GetMapping("edit/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model) {
        if (songService.getById(id) == null) {
            model.addAttribute("message", "Bài hát không tồn tại");
            return "error";
        }
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(songService.getById(id), songDto);
        model.addAttribute("songDto", songDto);
        return "edit";
    }

    @PostMapping("edit")
    public String updateSong(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Song song = songService.getById(songDto.getId());
        if (song == null) {
            model.addAttribute("message", "Bài hát không tồn tại");
            return "error";
        }
        BeanUtils.copyProperties(songDto, song);
        songService.update(song);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/song";
    }

    @PostMapping("delete")
    public String deleteSong(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes, Model model) {
        if (songService.getById(id) == null) {
            model.addAttribute("message", "Bài hát không tồn tại");
            return "error";
        }
        songService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Đã Xóa thành công");
        return "redirect:/song";
    }
}

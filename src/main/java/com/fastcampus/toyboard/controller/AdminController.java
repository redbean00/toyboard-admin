package com.fastcampus.toyboard.controller;

import com.fastcampus.toyboard.dto.BoardUserDto;
import com.fastcampus.toyboard.dto.BoardUserStatDto;
import com.fastcampus.toyboard.dto.UserRoleDto;
import com.fastcampus.toyboard.entity.Email;
import com.fastcampus.toyboard.service.BoardService;
import com.fastcampus.toyboard.service.EmailService;
import com.fastcampus.toyboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final EmailService emailService;

    @Autowired
    private final BoardService boardService;

    @GetMapping("/admin")
    public String mainForm() {
        return "/admin";
    }

    //회원 관리 페이지 - 전체 회원 목록 보여주고 등급을 변경할 수 있음
    @GetMapping("/admin/user")
    public String userForm(Model model) {
        List<UserRoleDto> userList = userService.getUserListWithAuthority();
        model.addAttribute("userList", userList);
        return "/user";
    }

    //회원 등급 변경
    @PostMapping("/admin/user/{userId}")
    public String manageUserAuthority(@PathVariable Long userId, UserRoleDto userRoleDto) {
        userService.updateUserRole(userId, userRoleDto);
        return "redirect:/admin/user";
    }

    //이메일 전송 화면
    @GetMapping("/admin/email")
    public String emailForm() {
        return "/email";
    }

    //이메일 전송
    @PostMapping("/admin/email/send")
    public String sendEmail(Email email) {
        emailService.sendMail(email);
        return "redirect:/admin/email";
    }

    //게시글 관리 페이지
    @GetMapping("/admin/board")
    public String boardForm(Model model) {
        List<BoardUserDto> boardList = boardService.getBoardListWithUser();
        model.addAttribute("boardList", boardList);
        return "/board";
    }

    //게시글 숨기기/보이기
    @GetMapping("/admin/board/{boardId}")
    public String managementHide(@PathVariable Long boardId) {
        boardService.updateHide(boardId);
        return "redirect:/admin/board";
    }

    //게시글 삭제하기
    @GetMapping("/admin/board/delete/{boardId}")
    public String deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return "redirect:/admin/board";
    }

    //블랙리스트 등록 -> 회원 등급 'BLACK' 변경
    @GetMapping("/admin/board/black/{boardId}")
    public String blacklist(@PathVariable Long boardId) {
        boardService.updateBlack(boardId);
        return "redirect:/admin/board";
    }

    //통계 관리 페이지
    @GetMapping("/admin/stat")
    public String statForm() {
        return "/stat";
    }

    //게시글 순으로 정렬
    @GetMapping("/admin/stat/board")
    public String statByBord(Model model) {
        List<BoardUserStatDto> list = boardService.getStatListByBoard();
        model.addAttribute("list", list);
        return "/boards";
    }

    //댓글 순으로 정렬
    @GetMapping("/admin/stat/comment")
    public String statByComment(Model model) {
        List<BoardUserStatDto> list = boardService.getStatListByComment();
        model.addAttribute("list", list);
        return "/comments";
    }

}

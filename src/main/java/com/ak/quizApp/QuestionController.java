package com.ak.quizApp;

import com.ak.quizApp.dto.QuestionInputDTO;
import com.ak.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@RestController
//@RequestMapping
@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestion() {
        return questionService.getAllQuestions();
    }

    @PostMapping("/createQuestion")
    public Question createQuestion(@Validated @RequestBody QuestionInputDTO questionInputDTO){
        return questionService.createQuestion(questionInputDTO);
    }

    @PostMapping("/createQuestion1")
    public String createQuestion1(@ModelAttribute("questionForm") QuestionInputDTO questionInputDTO, Model model) {
        Question question = questionService.createQuestion(questionInputDTO);
        model.addAttribute("questions", questionService.getAllQuestions());
        System.out.println(questionService.getAllQuestions());
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("appName", "My Spring Boot App");
        model.addAttribute("questions", questionService.getAllQuestions());
        return "welcome";
    }


    @GetMapping("/about")
    public String aboutPage() {
        return "navBar";
    }

    @GetMapping("/Projects")
    public String projectPage() {
        return "Success";
    }

    @GetMapping("/blog")
    public String blogPage() {
        return "Success";
    }

    @GetMapping("/createQ")
    public String createQue() {
        return "createQuestion";
    }
}

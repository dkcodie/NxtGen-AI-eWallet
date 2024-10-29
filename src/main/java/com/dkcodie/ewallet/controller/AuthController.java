package com.dkcodie.ewallet.controller;

import com.dkcodie.ewallet.dto.UserDto;
import com.dkcodie.ewallet.entity.Transaction;
import com.dkcodie.ewallet.entity.User;
import com.dkcodie.ewallet.service.TransactionService; // Make sure to import your TransactionService
import com.dkcodie.ewallet.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AuthController {
    private final UserService userService;
    private final TransactionService transactionService;

    @Autowired
    public AuthController(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
    @GetMapping("/users")
    public String users(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/usersById")
    public String listPeerUsers(Model model) {
        List<User> peerUsers = userService.findAllUsersExceptCurrent();
        model.addAttribute("peerUsers", peerUsers);
        return "users";
    }

    @GetMapping("/delete-user")
    public String deleteUser(@RequestParam("id") Long userId, RedirectAttributes redirectAttributes) {
        userService.deleteUserById(userId);
        redirectAttributes.addFlashAttribute("message", "User deleted successfully!");
        return "redirect:/users";
    }


    @PostMapping("/transfer")
    public String transferFunds(@RequestParam String email, @RequestParam Double amount, RedirectAttributes redirectAttributes) {
        User currentUser = userService.getCurrentUserDetails(); // Get the current user
        transactionService.createTransaction(currentUser.getId(), email, amount); // Create transaction

        redirectAttributes.addFlashAttribute("message", "Transfer successful!"); // Add success message
        return "redirect:/transactions"; // Redirect to the transactions page
    }

    @GetMapping("/transactions")
    public String getTransactionsPage(Model model) {
        User user = userService.getCurrentUserDetails();
        List<Transaction> transactions = transactionService.findTransactionsByUserId(user.getId());
        model.addAttribute("transactions", transactions);
        return "transactions"; // Ensure this matches the name of your HTML file
    }

    @GetMapping("/dashboard")
    public String getUserDashboard(Model model) {
        User user = userService.getCurrentUserDetails();
        model.addAttribute("user", user);
        List<Transaction> transactions = transactionService.findTransactionsByUserId(user.getId());
        model.addAttribute("transactions", transactions);
        return "dashboard";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }
        if (logout != null) {
            model.addAttribute("message", "You've been logged out successfully.");
        }
        return "login";
    }
}

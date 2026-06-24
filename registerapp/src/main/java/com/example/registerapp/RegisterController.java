@RestController
public class RegisterController {

    @GetMapping("/")
    public String home() {
        return "Application Running Successfully";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password) {

        // existing code
    }
}
 

import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println(p);
        // p.setEmail("b@c.com"); //compilation error implies immutability
        System.out.println("=> Now this solution, creates an immutable object.");
    }
}

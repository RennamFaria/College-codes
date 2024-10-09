package library.types;

import library.models.User;

public class StudentUserType extends User {
    public StudentUserType(String id, String name) {
        super(id, name, "Student");
    }
    
    // Lógica específica para estudantes
}

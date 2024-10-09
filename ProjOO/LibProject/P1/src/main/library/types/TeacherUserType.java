package library.types;

import library.models.User;

public class TeacherUserType extends User {
    public TeacherUserType(String id, String name) {
        super(id, name, "Teacher");
    }
    
    // Lógica específica para professores
}

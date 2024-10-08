package entities;

import java.util.List;

public class Category {
    private String name;
    private List<Category> subcategories;

    public Category(String name, List<Category> subcategories) {
        this.name = name;
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public void addSubcategory(Category subcategory) {
        subcategories.add(subcategory);
    }
}


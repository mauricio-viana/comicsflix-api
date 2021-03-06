package br.com.api.controllers.form;

import br.com.api.models.Category;
import br.com.api.repositories.CategoryRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoryForm {

    @NotNull @NotEmpty
    private String title;

    @NotNull @NotEmpty
    private String color;

    @NotNull @NotEmpty
    private String description;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category toConvert() {
        return new Category(this.title, this.color, this.description);
    }

    public Category update(Long id, CategoryRepository categoryRepository) {
        Category category = categoryRepository.getOne(id);

        category.setTitle(this.title);
        category.setColor(this.color);
        category.setDescription(this.description);

        return category;
    }
}

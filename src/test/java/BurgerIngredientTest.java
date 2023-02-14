import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerIngredientTest {

    Burger burger;
    Database database;
    List<Ingredient> ingredients;
    @Mock
    Bun buns;

    @Before
    public void setUp() {
        burger = new Burger();
        database = new Database();
        ingredients = database.availableIngredients();
        burger.setBuns(buns);
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(3));
    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(ingredients.get(5));
        String expected = "sausage";
        String actual = burger.ingredients.get(burger.ingredients.size() - 1).getName();
        assertEquals("Ингредиенты должны совпадать", expected, actual);
    }

    @Test
    public void shouldRemoveIngredient() {
        burger.removeIngredient(burger.ingredients.size() - 1);
        String expected = "dinosaur";
        String actual = burger.ingredients.get(burger.ingredients.size() - 1).getName();
        assertEquals("Ингредиенты должны совпадать", expected, actual);
    }

    @Test
    public void shouldMoveIngredient() {
        burger.moveIngredient(0, burger.ingredients.size() - 1);
        String expected = "sour cream";
        String actual = burger.ingredients.get(burger.ingredients.size() - 1).getName();
        assertEquals("Ингредиенты должны совпадать", expected, actual);
    }
}

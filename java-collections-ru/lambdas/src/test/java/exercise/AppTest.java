package exercise;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

//BEGIN
class AppTest {
    @Test
    void testSorterWithoutMan() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] expectedImage =  {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"}
        };
        String[][] enlargedImage = App.enlargeArrayImage(image);
        assertThat(enlargedImage).isEqualTo(expectedImage);
    }

}
//END
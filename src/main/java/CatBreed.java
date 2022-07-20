import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CatBreed {

    private int current_page;
    private ArrayList<Data> data;


    @Getter
    public static class Data {
        private String breed;
        private String country;
        private String origin;
        private String coat;
        private String pattern;

        @Override
        public String toString() {
            return breed + ", " + country+ ", " + origin+ ", " + coat + ", " + pattern + "\n";
        }
    }
}

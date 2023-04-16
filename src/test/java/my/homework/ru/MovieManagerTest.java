package my.homework.ru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieManagerTest {

    private MovieManager manager;

    @BeforeEach
    void setUp() {
        manager = new MovieManager();
    }

    @Test
    void testAddMovie() {
        manager.add("Movie 1");
        manager.add("Movie 2");
        String[] expected = {"Movie 1", "Movie 2"};
        String[] actual = manager.findAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testFindAllMovies() {
        manager.add("Movie 1");
        manager.add("Movie 2");
        manager.add("Movie 3");
        String[] expected = {"Movie 1", "Movie 2", "Movie 3"};
        String[] actual = manager.findAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testFindLastMoviesWhenEmpty() {
        String[] expected = {};
        String[] actual = manager.findLastMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testFindLastMoviesWhenLessThanLimit() {
        manager.add("Movie 1");
        manager.add("Movie 2");
        String[] expected = {"Movie 2", "Movie 1"};
        String[] actual = manager.findLastMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testFindLastMoviesWhenEqualLimit() {
        for (int i = 1; i <= 10; i++) {
            manager.add("Movie " + i);
        }
        String[] expected = {"Movie 10", "Movie 9", "Movie 8", "Movie 7", "Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        String[] actual = manager.findLastMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testFindLastMoviesWhenMoreThanLimit() {
        for (int i = 1; i <= 15; i++) {
            manager.add("Movie " + i);
        }
        String[] expected = {"Movie 15", "Movie 14", "Movie 13", "Movie 12", "Movie 11", "Movie 10", "Movie 9", "Movie 8", "Movie 7", "Movie 6"};
        String[] actual = manager.findLastMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testConstructorWithLimit() {
        MovieManager manager = new MovieManager(5);
        int expected = 5;
        int actual = manager.getLimit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDefaultConstructor() {
        MovieManager manager = new MovieManager();
        int expected = 10;
        int actual = manager.getLimit();
        Assertions.assertEquals(expected, actual);
    }


}

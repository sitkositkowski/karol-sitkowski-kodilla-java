package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Forum Test Suite")
public class ForumStatisticsTestSuite {

    private static int testCounter = 0;

    @Mock
    private final Statistics statistics = mock(Statistics.class);

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);

        List<String> userNames = new ArrayList<>();
        for (int i=0; i<10; i++) {
            userNames.add("user"+i);
        }
        when(statistics.userNames()).thenReturn(userNames);
        when(statistics.postsCount()).thenReturn(100);
        when(statistics.commentsCount()).thenReturn(1000);
    }

    @DisplayName("testPosts0")
    @Test
    void testPosts0() {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics(statistics);

        //When
        when(statistics.postsCount()).thenReturn(0);
        forumStatistics.calculateAdvStatistics();

        // then
        assertEquals(10, forumStatistics.getUserNumber());
        assertEquals(0, forumStatistics.getPostNumber());
        assertEquals(1000, forumStatistics.getCommentNumber());
        assertEquals(0,forumStatistics.getPostPerUser());
        assertEquals(100, forumStatistics.getCommentPerUser());
        assertEquals(Double.POSITIVE_INFINITY, forumStatistics.getCommentPerPost());
    }

    @DisplayName("testPosts1000")
    @Test
    void testPosts1000() {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics(statistics);

        //When
        when(statistics.postsCount()).thenReturn(1000);
        forumStatistics.calculateAdvStatistics();

        // then
        assertEquals(10, forumStatistics.getUserNumber());
        assertEquals(1000, forumStatistics.getPostNumber());
        assertEquals(1000, forumStatistics.getCommentNumber());
        assertEquals(100,forumStatistics.getPostPerUser());
        assertEquals(100, forumStatistics.getCommentPerUser());
        assertEquals(1, forumStatistics.getCommentPerPost());
    }

    @DisplayName("testComments0")
    @Test
    void testComments0() {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics(statistics);

        //When
        when(statistics.commentsCount()).thenReturn(0);
        forumStatistics.calculateAdvStatistics();

        // then
        assertEquals(10, forumStatistics.getUserNumber());
        assertEquals(100, forumStatistics.getPostNumber());
        assertEquals(0, forumStatistics.getCommentNumber());
        assertEquals(10,forumStatistics.getPostPerUser());
        assertEquals(0, forumStatistics.getCommentPerUser());
        assertEquals(0, forumStatistics.getCommentPerPost());
    }

    @DisplayName("testMoreCommentsThanPosts")
    @Test
    void testMoreCommentsThanPosts() {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics(statistics);

        //When
        forumStatistics.calculateAdvStatistics();

        // then
        assertEquals(10, forumStatistics.getUserNumber());
        assertEquals(100, forumStatistics.getPostNumber());
        assertEquals(1000, forumStatistics.getCommentNumber());
        assertEquals(10,forumStatistics.getPostPerUser());
        assertEquals(100, forumStatistics.getCommentPerUser());
        assertEquals(10, forumStatistics.getCommentPerPost());
    }

    @DisplayName("testMorePostsThanComments")
    @Test
    void testMorePostsThanComment() {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics(statistics);

        //When
        when(statistics.commentsCount()).thenReturn(1);
        forumStatistics.calculateAdvStatistics();

        // then
        assertEquals(10, forumStatistics.getUserNumber());
        assertEquals(100, forumStatistics.getPostNumber());
        assertEquals(1, forumStatistics.getCommentNumber());
        assertEquals(10,forumStatistics.getPostPerUser());
        assertEquals(0.1, forumStatistics.getCommentPerUser());
        assertEquals(0.01, forumStatistics.getCommentPerPost());
    }

    @DisplayName("testUsers100")
    @Test
    void testUsers100() {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics(statistics);
        List<String> userNames = new ArrayList<>();
        for (int i=0; i<100; i++) {
            userNames.add("user"+i);
        }
        //When
        when(statistics.userNames()).thenReturn(userNames);
        forumStatistics.calculateAdvStatistics();

        // then
        assertEquals(100, forumStatistics.getUserNumber());
        assertEquals(100, forumStatistics.getPostNumber());
        assertEquals(1000, forumStatistics.getCommentNumber());
        assertEquals(1,forumStatistics.getPostPerUser());
        assertEquals(10, forumStatistics.getCommentPerUser());
        assertEquals(10, forumStatistics.getCommentPerPost());
    }

    @DisplayName("testUsers100")
    @Test
    void testUsers0() {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics(statistics);
        List<String> userNames = new ArrayList<>();
        //When
        when(statistics.userNames()).thenReturn(userNames);
        forumStatistics.calculateAdvStatistics();

        // then
        assertEquals(0, forumStatistics.getUserNumber());
        assertEquals(100, forumStatistics.getPostNumber());
        assertEquals(1000, forumStatistics.getCommentNumber());
        assertEquals(Double.POSITIVE_INFINITY,forumStatistics.getPostPerUser());
        assertEquals(Double.POSITIVE_INFINITY, forumStatistics.getCommentPerUser());
        assertEquals(10, forumStatistics.getCommentPerPost());
    }

}

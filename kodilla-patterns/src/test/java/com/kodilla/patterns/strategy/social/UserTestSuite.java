package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.media.TwitterPublisher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User jacob = new ZGeneration("jacob05");
        User matthew = new Millenials("matthew89");
        User robert = new YGeneration("robert63");

        //When
        String jacobPost = jacob.sharePost("post");
        System.out.println(jacobPost);
        String matthewPost = matthew.sharePost("post");
        System.out.println(matthewPost);
        String robertPost = robert.sharePost("post");
        System.out.println(robertPost);

        //Then
        assertEquals("[Snap] : post", jacobPost);
        assertEquals("[FB post] : post", matthewPost);
        assertEquals("[Tweet] : post", robertPost);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User jacob = new ZGeneration("jacob05");

        //When
        String jacobPost = jacob.sharePost("post");
        System.out.println(jacobPost);
        jacob.setSocialPublisher(new TwitterPublisher());
        jacobPost = jacob.sharePost("post");
        System.out.println(jacobPost);

        //Then
        assertEquals("[Tweet] : post", jacobPost);
    }
}

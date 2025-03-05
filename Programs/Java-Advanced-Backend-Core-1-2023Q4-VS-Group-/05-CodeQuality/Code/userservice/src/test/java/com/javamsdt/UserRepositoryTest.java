package com.javamsdt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class UserRepositoryTest {

    @Mock
    private User userMock;

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userRepository = new UserRepository();
    }

    @Test
    void addUser() {
        userRepository.addUser(userMock);

        assertTrue(userRepository.getAllUsers().contains(userMock));
    }

    @Test
    void getUserByUsername_UserNotFound() {
        assertNull(userRepository.getUserByUsername("nonexistent_user"));
    }

    @Test
    void getUserByUsername_UserFound() {
        when(userMock.username()).thenReturn("existing_user");
        userRepository.addUser(userMock);

        assertEquals(userMock, userRepository.getUserByUsername("existing_user"));
    }

    @Test
    void getUsersByEmail() {
        when(userMock.email()).thenReturn("test@example.com");
        userRepository.addUser(userMock);

        List<User> users = userRepository.getUsersByEmail("test@example.com");

        assertEquals(1, users.size());
        assertEquals(userMock, users.get(0));
    }

    @Test
    void getUsersByDateOfBirth() {
        when(userMock.dateOfBirth()).thenReturn("2000-01-01");
        userRepository.addUser(userMock);

        List<User> users = userRepository.getUsersByDateOfBirth("2000-01-01");

        assertEquals(1, users.size());
        assertEquals(userMock, users.get(0));
    }

    @Test
    void getUsersByAddress() {
        when(userMock.address()).thenReturn("123 Test St");
        userRepository.addUser(userMock);

        List<User> users = userRepository.getUsersByAddress("123 Test St");

        assertEquals(1, users.size());
        assertEquals(userMock, users.get(0));
    }

    @Test
    void updateUser_UserNotFound() {
        when(userMock.username()).thenReturn("nonexistent_user");
        userRepository.updateUser(userMock);

        assertFalse(userRepository.getAllUsers().contains(userMock));
    }

    @Test
    void updateUser_UserFound() {
        when(userMock.username()).thenReturn("existing_user");
        userRepository.addUser(userMock);

        User updatedUser = new User("existing_user", "updated@example.com", "2000-01-01", "456 Updated St");
        userRepository.updateUser(updatedUser);

        assertTrue(userRepository.getAllUsers().contains(updatedUser));
    }

    @Test
    void deleteUser_UserNotFound() {
        userRepository.deleteUser("nonexistent_user");

        assertTrue(userRepository.getAllUsers().isEmpty());
    }

    @Test
    void deleteUser_UserFound() {
        when(userMock.username()).thenReturn("existing_user");
        userRepository.addUser(userMock);

        userRepository.deleteUser("existing_user");

        assertTrue(userRepository.getAllUsers().isEmpty());
    }

    @Test
    void getAllUsers() {
        userRepository.addUser(new User("user1", "user1@example.com", "1990-01-01", "123 User1 St"));
        userRepository.addUser(new User("user2", "user2@example.com", "1995-05-05", "456 User2 St"));

        List<User> allUsers = userRepository.getAllUsers();

        assertEquals(2, allUsers.size());
    }
}

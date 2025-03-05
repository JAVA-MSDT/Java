package com.javamsdt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addUser() {
        User user = new User("test_user", "test@example.com", "2000-01-01", "123 Test St");
        when(userRepositoryMock.getUserByUsername("test_user")).thenReturn(null);

        userService.addUser(user);

        verify(userRepositoryMock, times(1)).addUser(user);
    }

    @Test
    void getUserByUsername() {
        User expectedUser = new User("test_user", "test@example.com", "2000-01-01", "123 Test St");
        when(userRepositoryMock.getUserByUsername("test_user")).thenReturn(expectedUser);

        User actualUser = userService.getUserByUsername("test_user");

        assertEquals(expectedUser, actualUser);
    }

    @Test
    void getUsersByParameter_InvalidParameter() {
        List<User> users = userService.getUsersByParameter("invalid", "value");

        assertTrue(users.isEmpty());
    }

    @Test
    void getUsersByParameter_Username() {
        User expectedUser = new User("test_user", "test@example.com", "2000-01-01", "123 Test St");
        when(userRepositoryMock.getUserByUsername("test_user")).thenReturn(expectedUser);

        List<User> users = userService.getUsersByParameter("username", "test_user");

        assertEquals(1, users.size());
        assertEquals(expectedUser, users.get(0));
    }

    @Test
    void getUsersByParameter_Email() {
        User expectedUser = new User("test_user", "test@example.com", "2000-01-01", "123 Test St");
        when(userRepositoryMock.getUsersByEmail("test@example.com")).thenReturn(List.of(expectedUser));

        List<User> users = userService.getUsersByParameter("email", "test@example.com");

        assertEquals(1, users.size());
        assertEquals(expectedUser, users.get(0));
    }

    @Test
    void getUsersByParameter_DateOfBirth() {
        User expectedUser = new User("test_user", "test@example.com", "2000-01-01", "123 Test St");
        when(userRepositoryMock.getUsersByDateOfBirth("2000-01-01")).thenReturn(List.of(expectedUser));

        List<User> users = userService.getUsersByParameter("dateofbirth", "2000-01-01");

        assertEquals(1, users.size());
        assertEquals(expectedUser, users.get(0));
    }

    @Test
    void getUsersByParameter_Address() {
        User expectedUser = new User("test_user", "test@example.com", "2000-01-01", "123 Test St");
        when(userRepositoryMock.getUsersByAddress("123 Test St")).thenReturn(List.of(expectedUser));

        List<User> users = userService.getUsersByParameter("address", "123 Test St");

        assertEquals(1, users.size());
        assertEquals(expectedUser, users.get(0));
    }
}
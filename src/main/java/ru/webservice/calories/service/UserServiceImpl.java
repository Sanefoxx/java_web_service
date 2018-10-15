package ru.webservice.calories.service;

import ru.webservice.calories.model.User;
import ru.webservice.calories.repository.UserRepository;
import ru.webservice.calories.util.exception.NotFoundException;

import java.util.List;

import static ru.webservice.calories.util.ValidationUtil.checkNotFound;
import static ru.webservice.calories.util.ValidationUtil.checkNotFoundWithId;

public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(User user) {
        checkNotFoundWithId(repository.save(user), user.getId());
    }
}
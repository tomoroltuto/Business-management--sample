package com.example.businessmanagement.service.user;

import com.example.businessmanagement.repository.user.UserRecord;
import com.example.businessmanagement.repository.user.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserEntity find(long userId) {
    return userRepository.select(userId).map(
            record -> new UserEntity(record.getId(), record.getCompanyname(), record.getUsername()))
        .orElseThrow(() -> new UserEntityNotFoundException(userId));
  }

  public List<UserEntity> find() {
    return userRepository.selectList().stream().map(
            record -> new UserEntity(record.getId(), record.getCompanyname(), record.getUsername()))
        .collect(Collectors.toList());
  }

  public UserEntity create(String companyname, String username) {
    var record = new UserRecord(null, companyname, username);
    userRepository.insert(record);
    return new UserEntity(record.getId(), record.getCompanyname(), record.getUsername());
  }

  public UserEntity update(Long userId, String companyname, String username) {
    userRepository.select(userId)
        .orElseThrow(() -> new UserEntityNotFoundException(userId));
    userRepository.update(new UserRecord(userId, companyname, username));
    return find(userId);
  }

  public void delete(Long userId) {
    userRepository.select(userId)
        .orElseThrow(() -> new UserEntityNotFoundException(userId));
    userRepository.delete(userId);
  }
}

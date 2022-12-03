package com.example.businessmanagement.controller.user;


import com.example.businessmanagement.service.user.UserEntity;
import com.example.businessmanagement.service.user.UserService;
import com.example.todoapi.controller.UsersApi;
import com.example.todoapi.model.UserDTO;
import com.example.todoapi.model.UserForm;
import com.example.todoapi.model.UserListDTO;
import com.example.todoapi.model.UserResponseMessage;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {

	private final UserService userService;

	private static UserDTO toUserDTO(UserEntity userEntity) {
		var userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setCompanyName(userEntity.getCompanyname());
		userDTO.setUserName(userEntity.getUsername());
		return userDTO;
	}


	@Override
	public ResponseEntity<UserDTO> showUser(Long userId) {
		var entity = userService.find(userId);
		var dto = toUserDTO(entity);
		return ResponseEntity.ok(dto);
	}

	@Override
	public ResponseEntity<UserListDTO> userList() {
		var entityList = userService.find();
		var dtoList = entityList
				.stream()
				.map(UserController::toUserDTO)
				.collect(Collectors.toList());
		var dto = new UserListDTO();
		dto.setResults(dtoList);
		return ResponseEntity.ok(dto);
	}

	@Override
	public ResponseEntity<UserResponseMessage> createUser(UserForm form) {
		userService.create(form.getCompanyName(), form.getUserName());
		var urm = new UserResponseMessage();
		urm.setMessage("ユーザーを登録しました");
		return ResponseEntity.ok(urm);
	}

	@Override
	public ResponseEntity<UserResponseMessage> updateUser(Long userId, UserForm form) {
		userService.update(userId, form.getCompanyName(), form.getUserName());
		var urm = new UserResponseMessage();
		urm.setMessage("ユーザーを更新しました");
		return ResponseEntity.ok(urm);
	}

	@Override
	public ResponseEntity<UserResponseMessage> deleteUser(Long userId) {
		userService.delete(userId);
		var urm = new UserResponseMessage();
		urm.setMessage("ユーザーを削除しました");
		return ResponseEntity.ok(urm);
	}
}
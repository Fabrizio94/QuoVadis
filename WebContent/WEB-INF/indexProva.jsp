<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/stylmod.css" rel="stylesheet">
<title>Subscription</title>
</head>
<body>
	
		<div class="col-md-4 col-md-offset-4">
			<div class="form_container">
				<form action="subscribe" method="get">
					<div class="form-group">
						<p>
							${nameError }
						</p>
						<label>Name</label> <input type="text" class="form-control"
							placeholder="Name" name="name"
							value='${param["name"]}'>
					</div>
					<div class="form-group">
						<p>
							${surnameError }
						</p>
						<label>Surname</label> <input type="text" class="form-control"
							placeholder="Surname" name="surname"
							value='${param["surname"]}'>
					</div>
					<div class="form-group">
						<p>
							${usernameError}
						</p>
						<label>Username</label><input type="text" class="form-control"
							placeholder="Username" name="username"
							value='${param["username"]}'>
					</div>
					<div class="form-group">
						<p>
							${password1Error}
						</p>
						<label>Password </label><input type="text" class="form-control"
							placeholder="Password1" name="password1"
							value='${param["password1"]}'>
					</div>
					<div class="form-group">
						<p>
							${password2Error}
						</p>
						<label>Confirm Password</label><input type="text" class="form-control"
							placeholder="Password2" name="password2"
							value='${param["password2"]}'>
					</div>
					<button type="submit" class="btn btn-default">Invia</button>
				</form>
			</div>
		</div>

</body>
</html>
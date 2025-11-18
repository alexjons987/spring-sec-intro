# Spring Security introduction
### Task
1. **Create a new Spring Boot project**
* Include Spring Web + Spring Security.

2. **Create two REST endpoints:**
* `GET /public/hello` – should not require login
* `GET /private/secret` – should require login

3. **Configure Spring Security to:**
* use HTTP Basic authentication
* allow all traffic to `/public/**` without requiring authentication
* require authentication for all other endpoints

4. **Add an in-memory user, e.g.:**
* username: `student`
* password: `password`
* role: `USER`

5. **Test in Postman or browser:**
* Verify that `/public/hello` works without login
* Verify that `/private/secret` responds with a `401` without credentials
* Verify that the endpoint works when you send the correct username + password
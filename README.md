# zuul-gateway

OAUTH implementation:

This project will help to get OAUTH token from authorization server and authenticate all eureka registered services using resource server in centralised way.

For registration:

http://localhost:8766/api/auth/register
{
"email":"nitesh@gmail.com",
"password" : "nitesh123",
"fullname": "Nitesh_kumar",
"isEnabled" : true,
"roles" : [{"role":"ADMIN"}]
}

For getting access token at login time:
http://localhost:8766/oauth/token?grant_type=password&username=nitesh@gmail.com&password=nitesh123
username :my-trusted-client password: secret
Authorization Basic bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0

Response:
Admin
{
"access_token": "f214b811-8946-4a20-aa51-e9b8ce91ebab",
"token_type": "bearer",
"refresh_token": "8f50e47c-d5c3-4256-9045-474ea00e6349",
"expires_in": 1999,
"scope": "read write trust"
}

If access token expired than we will get access_token from refresh_token
For getting access token from refresh token
http://localhost:8765/oauth/token?grant_type=refresh_token&refresh_token=8f50e47c-d5c3-4256-9045-474ea00e6349
Authorization Basic bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0

If refresh_token will expire than we will call again to get access token and refresh token from fresh.

Unauthorized:
Code: 401
Message : {
"error": "unauthorized",
"error_description": "Full authentication is required to access this resource"
}

Code: 401
Message : {
"error": "invalid_token",
"error_description": "Access token expired: e0f3a2aa-e101-4f7c-ac7c-e7af131a2919"
}


refresh token expired
code : 400

message: {
"error": "invalid_grant",
"error_description": "Invalid refresh token: a02b562f-9626-4e3a-84e3-ed94d645b484"
}

code: 403 (when role does not have access resource)
Message: {
"error": "access_denied",
"error_description": "Access is denied"
}

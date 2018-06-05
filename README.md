# RankensteinAPI

## Contributors
>> Harankumar Nallasivan, *Backend Spring Application*

>> Benjamin Yan, *Front-End React Native Application*

## Instructions
### Requirements
1. [Maven](https://maven.apache.org/install.html)
1. [MongoDB](https://www.mongodb.com/download-center?jmp=nav#community)
1. [Postman](https://www.getpostman.com/)
### Testing
`mvn test`

In order to test the API, I recommend the software [Postman](https://www.getpostman.com/), which gives you fine-grained control over your HTTP requests.
### Running the Server
Make sure the MongoDB daemon is running.

`mvn spring-boot:run`

## APIs
<table>
<thead>
    <td>URI</td>
    <td>Method</td>
    <td>URL Params/POST Body</td>
    <td>Examples</td>
    <td>Requirements</td>
</thead>
<tbody>
<tr>
    <td>/api/hello</td>
    <td>GET</td>
    <td>name (optional)</td>
    <td>
        <p>/api/hello</p>
        <pre>
            {
                "data": "Hello, world!",
                "metadata": {
                    "status": 200,
                    "page": 1,
                    "seed": 1,
                    "size": 1
                }
            }
        </pre>
        <p>/api/hello?name=Ben</p>
        <pre>
            "data": "Hello, Ben!",
            "metadata": {
                "status": 200,
                "page": 1,
                "seed": 1,
                "size": 1
            }
        </pre>
    </td>
    <td>Authenticated</td>
</tr>
<tr>
    <td>
        /api/public/register
    </td>
    <td>
        POST
    </td>
    <td>
        <pre>
            {
                "username": "String", // at least 5 characters long, starting with an alphabetical character, all alphanumeric
                "password": "String", // at least 8 characters long, a-z, A-Z, 0-9, ~, !, @, #, $, %, ^, &, or *
                "phoneNumber": "String" // valid phone number shape
            }    
        </pre>
    </td>
    <td>
        <pre>
            {
                "username": "neo123",
                "password": "password",
                "phoneNumber": "+1 555-555-5555"
            }
        </pre>
    </td>
    <td>
        Unauthenticated
    </td>
</tr>
<tr>
    <td>
        /api/public/login
    </td>
    <td>
        POST
    </td>
    <td>
        <pre>
            {
                "username": "String", // not empty
                "password": "String", // not empty
            }    
        </pre>
    </td>
    <td>
        <pre>
            {
                "username": "neo123",
                "password": "password"
            }
        </pre>
    </td>
    <td>
        Unauthenticated
    </td>
</tr>
<tr>
    <td>
        /api/public/logout
    </td>
    <td>
        POST
    </td>
    <td>
        N/A
    </td>
    <td>
        N/A
    </td>
    <td>
        Authenticated
    </td>
</tr>
<tr>
    <td>
        /api/public/confirmation
    </td>
    <td>
        POST
    </td>
    <td>
        username, confirmationCode
    </td>
    <td>
        <p>/api/public/confirmation?username=neo123&confirmationCode=2018</p>
    </td>
    <td>
        Unauthenticated
    </td>
</tr>
<tr>
    <td>
        /api/user/set-name
    </td>
    <td>
        POST
    </td>
    <td>
        name
    </td>
    <td>
        <p>/api/user/set-name?name=Thomas%20Anderson</p>
    </td>
    <td>
        Authenticated
    </td>
</tr>
<tr>
    <td>
        /api/user/set-nickname
    </td>
    <td>
        POST
    </td>
    <td>
        nickname
    </td>
    <td>
        <p>/api/user/set-name?nickname=Neo</p>
    </td>
    <td>
        Authenticated
    </td>
</tr>
</tbody>
</table>

# RankensteinAPI

## Contributors
>> Harankumar Nallasivan, *Backend Spring Application*

>> Benjamin Yan, *Front-End React Native Application*

>> Vamshikrishnan Balakrishnan

## Instructions
### Testing
mvn test
### Running the Server
mvn spring-boot:run

## APIs
<table>
<thead>
    <td>URI</td>
    <td>Method</td>
    <td>Params</td>
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
    <td>None</td>
</tr>
</tbody>
</table>

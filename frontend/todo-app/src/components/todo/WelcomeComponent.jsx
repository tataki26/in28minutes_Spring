import { useParams, Link } from 'react-router-dom'
import axios from 'axios'

export default function WelcomeComponent() {
    // const params = useParams()
    const { username } = useParams()

    function callHelloWorldRestApi() {
        console.log('called');
        axios.get('http://localhost:8080/hello-world')
            .then((response) => successfulResponse(response)
            )
            .catch((error) => errorResponse(error));
    }

    function successfulResponse(response) {
        console.log(response);
    }

    function errorResponse(error) {
        console.log(error);
    }

    return (
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div className="Welcome">
                Manage your todos - <Link to="/todos">Go here!</Link>
            </div>
                <button className="btn btn-success m-5" onClick={callHelloWorldRestApi}>
                    Call Hello World</button>
        </div>
    )
}

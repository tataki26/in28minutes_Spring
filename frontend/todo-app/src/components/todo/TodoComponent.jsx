import { useParams } from "react-router-dom"
import { useAuth } from "./security/AuthContext";
import { retrieveTodoApi } from "./api/TodoApiService";
import { useEffect, useState } from "react";


export default function TodoComponent() {
    const {id} = useParams();

    const authContext = useAuth();
    const username = authContext.username;

    const [description, setDescription] = useState('');

    function retrieveTodo() {
        retrieveTodoApi(username, id)
        .then(response => {
            setDescription(response.data.description);
        })
        .catch(error => console.log(error));
    }

    useEffect(
        () => retrieveTodo(),
        [id]
    );

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div>
                description: {description}
            </div>
        </div>
    )
}
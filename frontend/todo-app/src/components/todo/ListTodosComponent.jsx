import { useEffect, useState } from "react";
import { retrieveAllTodosForUsername } from "./api/TodoApiService";

export default function ListTodosComponent() {
    const [todos, setTodos] = useState([]);

    useEffect (() => refreshTodos(), [])

    function refreshTodos() {
        retrieveAllTodosForUsername('in28minutes')
        .then(response => {
            setTodos(response.data);
        })
        .catch(error => console.log(error));
    }

    return (
        <div className="container">
            <h1>Things You Want To DO!</h1>
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Description</td>
                            <td>Is Done?</td>
                            <td>Target Date</td>
                        </tr>
                    </thead>
                    <tbody>
                    {
                        todos.map(
                            todo => (
                                <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.description}</td>
                                    <td>{todo.done.toString()}</td>
                                    <td>{todo.targetDate.toString()}</td>
                                </tr>
                            )
                        )
                    }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

import { useParams } from "react-router-dom"
import { useAuth } from "./security/AuthContext";
import { retrieveTodoApi } from "./api/TodoApiService";
import { useEffect, useState } from "react";
import { Field, Formik, Form } from "formik";


export default function TodoComponent() {
    const {id} = useParams();

    const authContext = useAuth();
    const username = authContext.username;

    const [description, setDescription] = useState('');
    const [targetDate, setTargetDate] = useState('');

    function retrieveTodo() {
        retrieveTodoApi(username, id)
        .then(response => {
            setDescription(response.data.description);
            setTargetDate(response.data.targetDate);
        })
        .catch(error => console.log(error));
    }

    function onSubmit(values) {
        console.log(values);
    }

    useEffect(
        () => retrieveTodo(),
        [id]
    );

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div>
                <Formik initialValues={ {description, targetDate} }
                    enableReinitialize = {true}
                    onSubmit = {onSubmit}
                    >
                    {
                        (props) => (
                            <Form>
                                <fieldset className="form-group">
                                    <label>Description</label>
                                    <Field type="text" className="form-control" name="description"/>
                                </fieldset>
                                <fieldset className="form-group">
                                    <label>Target Date</label>
                                    <Field type="date" className="form-control" name="targetDate"/>
                                </fieldset>
                                <div>
                                    <button className="btn btn-success m-5" type="submit">Save</button>
                                </div>
                            </Form>
                        )
                    }
                </Formik>
            </div>
        </div>
    )
}
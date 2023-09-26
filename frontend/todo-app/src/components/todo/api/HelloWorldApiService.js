import { apiClient } from "./ApiClient";

export const retrieveHelloWorldBean
    = () => apiClient.get('/hello-world-bean');

export const retrieveHelloWorldPathVariable
    = (username, token) => apiClient.get(`/hello-world/path-variable/${username}`
    // automatically applied using interceptor
    /*, {
        headers: {
            // Response to preflight request doesn't pass access control check => Authorization header
            Authorization: token
        }
    } */);

export const executeBasicAuthenticationService
    = (token) => apiClient.get(`/basicauth`, {
        headers: {
            Authorization: token
        }
    });
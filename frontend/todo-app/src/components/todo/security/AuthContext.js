import { createContext, useState, useContext } from "react";
import { apiClient } from "../api/ApiClient";
import { executeJwtAuthenticationService } from "../api/AuthenticationApiService";

// Create a Context
export const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)

// Share the created context with other components
export default function AuthProvider({ children }) {
    // Put some state in the context
    const [isAuthenticated, setAuthenticated] = useState(false);
    const [username, setUsername] = useState(null);
    const [token, setToken] = useState(null);

    // JavaScript object
    // const valueToBeShared = {number, isAuthenticated, setAuthenticated}

    // hard coding
    /*
    function login(username, password) {
        if(username === 'in28minutes' && password === 'dummy') {
            setAuthenticated(true);
            setUsername(username);
            return true;
        } else {
            setAuthenticated(false);
            setUsername(null);
            return false;
        }
    }
    */

    // Basic
    /*
    async function login(username, password) {
        // Base64 encoding
        const baToken = 'Basic ' + window.btoa(username + ":" + password);
        
        try {
            // wait until this code is finished
            const response = await executeBasicAuthenticationService(baToken)

            if(response.status == 200) {
                setAuthenticated(true);
                setUsername(username);
                // set into context
                setToken(baToken);
                apiClient.interceptors.request.use(
                    (config) => {
                        console.log('intercepting and adding a token');
                        config.headers.Authorization=baToken;
                        return config;
                    }
                )
                return true;
            } else {
                logout();
                return false;
            }
        } catch (error) {
            logout();
            return false;
        }
    }
    */

    // JWT Version
    async function login(username, password) {        
        try {
            // wait until this code is finished
            const response = await executeJwtAuthenticationService(username, password)

            if(response.status == 200) {
                const jwtToken = 'Bearer ' + response.data.token;

                setAuthenticated(true);
                setUsername(username);
                // set into context
                setToken(jwtToken);

                apiClient.interceptors.request.use(
                    (config) => {
                        console.log('intercepting and adding a token');
                        config.headers.Authorization=jwtToken;
                        return config;
                    }
                )
                return true;
            } else {
                logout();
                return false;
            }
        } catch (error) {
            logout();
            return false;
        }
    }

    function logout() {
        setAuthenticated(false);
        setUsername(null);
        setToken(null);
    }

    return (
        <AuthContext.Provider value={ {isAuthenticated, username, token, login, logout} }>
            {children}
        </AuthContext.Provider>
    )
}
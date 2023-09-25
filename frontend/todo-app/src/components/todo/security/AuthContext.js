import { createContext, useState, useContext } from "react";
import { executeBasicAuthenticationService } from "../api/HelloWorldApiService";

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
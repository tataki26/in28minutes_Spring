import { createContext, useState, useContext } from "react";

// Create a Context
export const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)

// Share the created context with other components
export default function AuthProvider({ children }) {
    // Put some state in the context
    const [number, setNumber] = useState(10);
    
    const [isAuthenticated, setAuthenticated] = useState(false);

    // setInterval( () => setNumber(number + 1), 10000)

    // JavaScript object
    // const valueToBeShared = {number, isAuthenticated, setAuthenticated}

    return (
        <AuthContext.Provider value={ {number, isAuthenticated, setAuthenticated} }>
            {children}
        </AuthContext.Provider>
    )
}
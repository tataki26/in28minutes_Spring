import { BrowserRouter, Routes, Route } from 'react-router-dom'
import HeaderComponent from './HeaderComponent'
import LoginComponent from './LoginComponent'
import WelcomeComponent from './WelcomeComponent'
import ListTodosComponent from './ListTodosComponent'
import LogoutComponent from './LogoutComponent'
import ErrorComponent from './ErrorComponent'
import './TodoApp.css'

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
                <HeaderComponent />
                <Routes>
                    <Route path='/' element={ <LoginComponent /> } />
                    <Route path='/login' element={ <LoginComponent /> } />
                    <Route path='/welcome/:username' element={ <WelcomeComponent /> } />
                    <Route path='/todos' element={ <ListTodosComponent /> } />
                    <Route path='/logout' element={ <LogoutComponent /> } />

                    <Route path='/*' element={ <ErrorComponent /> } />
                </Routes>  
            </BrowserRouter>
        </div>
    )
}

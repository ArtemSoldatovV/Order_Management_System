import React from 'react';

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Dashboard from './components/Dashboard';
import ClientManagement from './components/ClientManagement';
import OrderManagementPage from './components/OrderManagementPage';
import ProductManagementPage from './components/ProductManagementPage';
import OrderForm from './components/OrderForm';

const App = () => {
    return (
        <Router>
            <Navbar />
            <Routes>
                <Route exact path="/" element={<Dashboard />} />
                <Route path="/ClientManagement" element={<ClientManagement />} />
                <Route path="/OrderManagementPage" element={<OrderManagementPage />}/>
                <Route path="/ProductManagementPage" element={<ProductManagementPage />} />
                <Route path="/OrderForm" element={<OrderForm />}
                />
            </Routes>
        </Router>

    );
};

export default App;
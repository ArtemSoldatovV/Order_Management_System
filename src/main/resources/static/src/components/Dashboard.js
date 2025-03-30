import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Dashboard = () => {
    const [clientCount, setClientCount] = useState(0);
    const [orderCount, setOrderCount] = useState(0);
    const [totalAmount, setTotalAmount] = useState(0);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const clientsResponse = await axios.get('/api/clients/count');
                const ordersResponse = await axios.get('/api/orders/count');
                const totalAmountResponse = await axios.get('/api/orders/total-amount');

                setClientCount(clientsResponse.data.count);
                setOrderCount(ordersResponse.data.count);
                setTotalAmount(totalAmountResponse.data.totalAmount);
            } catch (error) {
                console.error('Ошибка при получении данных:', error);
            }
        };

        fetchData();
    }, []);

    return (
        <div>
            <h2>Статистика</h2>
            <p>Количество клиентов: {clientCount}</p>
            <p>Количество заказов: {orderCount}</p>
            <p>Общая сумма всех заказов: {totalAmount} ₽</p>
        </div>
    );
};

export default Dashboard;
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const OrderForm = () => {
    const [clients, setClients] = useState([]);
    const [orderDate, setOrderDate] = useState('');
    const [status, setStatus] = useState('');
    const [clientId, setClientId] = useState('');

    useEffect(() => {
        // Получаем список клиентов для выбора
        const fetchClients = async () => {
            const response = await axios.get('/api/clients');
            setClients(response.data);
        };
        fetchClients();
    }, []);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const newOrder = {
            orderDate: orderDate,
            status: status,
            client: { id: clientId } // Предполагается, что клиент передается как объект с id
        };

        try {
            await axios.post('/api/orders', newOrder);
            alert('Заказ успешно создан!');
            // Очистка формы
            setOrderDate('');
            setStatus('');
            setClientId('');
        } catch (error) {
            console.error('Ошибка при создании заказа:', error);
            alert('Ошибка при создании заказа');
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Клиент:</label>
                <select value={clientId} onChange={(e) => setClientId(e.target.value)} required>
                    <option value="">Выберите клиента</option>
                    {clients.map(client => (
                        <option key={client.id} value={client.id}>{client.name}</option>
                    ))}
                </select>
            </div>
            <div>
                <label>Дата заказа:</label>
                <input
                    type="date"
                    value={orderDate}
                    onChange={(e) => setOrderDate(e.target.value)}
                    required
                />
            </div>
            <div>
                <label>Статус:</label>
                <input
                    type="text"
                    value={status}
                    onChange={(e) => setStatus(e.target.value)}
                    required
                />
            </div>
            <button type="submit">Создать заказ</button>
        </form>
    );
};

export default OrderForm;
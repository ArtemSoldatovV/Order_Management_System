import React, { useEffect, useState } from 'react';
import axios from 'axios';

const OrderManagementPage = () => {
    const [orders, setOrders] = useState([]);
    const [filteredOrders, setFilteredOrders] = useState([]);
    const [clients, setClients] = useState([]);
    const [selectedOrder, setSelectedOrder] = useState(null);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [filterClient, setFilterClient] = useState('');
    const [filterStatus, setFilterStatus] = useState('');

    useEffect(() => {
        fetchOrders();
        fetchClients();
    }, []);

    const fetchOrders = async () => {
        try {
            const response = await axios.get('/api/orders');
            setOrders(response.data);
            setFilteredOrders(response.data);
        } catch (error) {
            console.error('Ошибка при получении заказов:', error);
        }
    };

    const fetchClients = async () => {
        try {
            const response = await axios.get('/api/clients');
            setClients(response.data);
        } catch (error) {
            console.error('Ошибка при получении клиентов:', error);
        }
    };

    const handleFilter = () => {
        const filtered = orders.filter(order => {
            return (
                (filterClient ? order.clientId === filterClient : true) &&
                (filterStatus ? order.status === filterStatus : true)
            );
        });
        setFilteredOrders(filtered);
    };

    const handleAddOrder = () => {
        setSelectedOrder(null);
        setIsModalOpen(true);
    };

    const handleEditOrder = (order) => {
        setSelectedOrder(order);
        setIsModalOpen(true);
    };

    const handleDeleteOrder = async (orderId) => {
        if (window.confirm('Вы уверены, что хотите удалить этот заказ?')) {
            try {
                await axios.delete(`/api/orders/${orderId}`);
                fetchOrders();
            } catch (error) {
                console.error('Ошибка при удалении заказа:', error);
            }
        }
    };

    const handleModalClose = () => {
        setIsModalOpen(false);
        fetchOrders(); // Обновляем список заказов после закрытия модального окна
    };

    return (
        <div>
            <h2>Управление заказами</h2>
            <div>
                <label>Фильтр по клиенту:</label>
                <select value={filterClient} onChange={(e) => setFilterClient(e.target.value)}>
                    <option value="">Все клиенты</option>
                    {clients.map(client => (
                        <option key={client.id} value={client.id}>{client.name}</option>
                    ))}
                </select>

                <label>Фильтр по статусу:</label>
                <select value={filterStatus} onChange={(e) => setFilterStatus(e.target.value)}>
                    <option value="">Все статусы</option>
                    <option value="pending">В ожидании</option>
                    <option value="completed">Завершен</option>
                    <option value="canceled">Отменен</option>
                </select>

                <button onClick={handleFilter}>Применить фильтр</button>
                <button onClick={handleAddOrder}>Добавить заказ</button>
            </div>

            <table>
                <thead>
                <tr>
                    <th>Номер</th>
                    <th>Клиент</th>
                    <th>Статус</th>
                    <th>Сумма</th>
                    <th>Действия</th>
                </tr>
                </thead>
                <tbody>
                {filteredOrders.map(order => (
                    <tr key={order.id}>
                        <td>{order.id}</td>
                        <td>{order.clientName}</td>
                        <td>{order.status}</td>
                        <td>{order.amount}</td>
                        <td>
                            <button onClick={() => handleEditOrder(order)}>Редактировать</button>
                            <button onClick={() => handleDeleteOrder(order.id)}>Удалить</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>

            {isModalOpen && (
                <OrderModal order={selectedOrder} onClose={handleModalClose} />
            )}
        </div>
    );
};

const OrderModal = ({ order, onClose }) => {
    const [clientId, setClientId] = useState(order ? order.clientId : '');
    const [status, setStatus] = useState(order ? order.status : '');
    const [amount, setAmount] = useState(order ? order.amount : '');

    const handleSubmit = async (e) => {
        e.preventDefault();
        const orderData = { clientId, status, amount };

        try {
            if (order) {
                // Редактирование заказа
                await axios.put(`/api/orders/${order.id}`, orderData);
            } else {
                // Добавление нового заказа
                await axios.post('/api/orders', orderData);
            }
            onClose();
        } catch (error) {
            console.error('Ошибка при сохранении заказа:', error);
        }
    };

    return (
        <div className="modal">
            <h2>{order ? 'Редактировать заказ' : 'Добавить заказ'}</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Клиент:</label>
                    <select value={clientId} onChange={(e) => setClientId(e.target.value)} required>
                        <option value="">Выберите клиента</option>
                        {/* Здесь вы можете добавить список клиентов */}
                    </select>
                </div>
                <div>
                    <label>Статус:</label>
                    <select value={status} onChange={(e) => setStatus(e.target.value)} required>
                        <option value="pending">В ожидании</option>
                        <option value="completed">Завершен</option>
                        <option value="canceled">Отменен</option>
                    </select>
                </div>
                <div>
                    <label>Сумма:</label>
                    <input
                        type="number"
                        value={amount}
                        onChange={(e) => setAmount(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">{order ? 'Сохранить' : 'Добавить'}</button>
                <button type="button" onClick={onClose}>Закрыть</button>
            </form>
        </div>
    );
};

export default OrderManagementPage;
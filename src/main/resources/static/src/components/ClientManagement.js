import React, { useEffect, useState } from 'react';
import axios from 'axios';

const ClientManagement = () => {
    const [clients, setClients] = useState([]);
    const [clientId, setClientId] = useState(null);
    const [clientName, setClientName] = useState('');
    const [clientEmail, setClientEmail] = useState('');

    useEffect(() => {
        fetchClients();
    }, []);

    const fetchClients = async () => {
        try {
            const response = await axios.get('/api/clients');
            setClients(response.data);
        } catch (error) {
            console.error('Ошибка при получении клиентов:', error);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const clientData = { name: clientName, email: clientEmail };

        try {
            if (clientId) {
                // Редактирование клиента
                await axios.put(`/api/clients/${clientId}`, clientData);
            } else {
                // Добавление нового клиента
                await axios.post('/api/clients', clientData);
            }
            fetchClients();
            resetForm();
        } catch (error) {
            console.error('Ошибка при сохранении клиента:', error);
        }
    };

    const handleEdit = (client) => {
        setClientId(client.id);
        setClientName(client.name);
        setClientEmail(client.email);
    };

    const handleDelete = async (clientId) => {
        if (window.confirm('Вы уверены, что хотите удалить этого клиента?')) {
            try {
                await axios.delete(`/api/clients/${clientId}`);
                fetchClients();
            } catch (error) {
                console.error('Ошибка при удалении клиента:', error);
            }
        }
    };

    const resetForm = () => {
        setClientId(null);
        setClientName('');
        setClientEmail('');
    };

    return (
        <div>
            <h2>Управление клиентами</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Имя клиента:</label>
                    <input
                        type="text"
                        value={clientName}
                        onChange={(e) => setClientName(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Email клиента:</label>
                    <input
                        type="email"
                        value={clientEmail}
                        onChange={(e) => setClientEmail(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">{clientId ? 'Редактировать' : 'Добавить'} клиента</button>
                <button type="button" onClick={resetForm}>Сбросить</button>
            </form>

            <h3>Список клиентов</h3>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Email</th>
                    <th>Действия</th>
                </tr>
                </thead>
                <tbody>
                {clients.map(client => (
                    <tr key={client.id}>
                        <td>{client.id}</td>
                        <td>{client.name}</td>
                        <td>{client.email}</td>
                        <td>
                            <button onClick={() => handleEdit(client)}>Редактировать</button>
                            <button onClick={() => handleDelete(client.id)}>Удалить</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ClientManagement;
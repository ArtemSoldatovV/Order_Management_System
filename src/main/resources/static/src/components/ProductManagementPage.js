import React, { useEffect, useState } from 'react';
import axios from 'axios';

const ProductManagementPage = () => {
    const [products, setProducts] = useState([]);
    const [selectedProduct, setSelectedProduct] = useState(null);
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [name, setName] = useState('');
    const [price, setPrice] = useState('');

    useEffect(() => {
        fetchProducts();
    }, []);

    const fetchProducts = async () => {
        try {
            const response = await axios.get('/api/products');
            setProducts(response.data);
        } catch (error) {
            console.error('Ошибка при получении товаров:', error);
        }
    };

    const handleAddProduct = () => {
        setSelectedProduct(null);
        setName('');
        setPrice('');
        setIsModalOpen(true);
    };

    const handleEditProduct = (product) => {
        setSelectedProduct(product);
        setName(product.name);
        setPrice(product.price);
        setIsModalOpen(true);
    };

    const handleDeleteProduct = async (productId) => {
        if (window.confirm('Вы уверены, что хотите удалить этот товар?')) {
            try {
                await axios.delete(`/api/products/${productId}`);
                fetchProducts();
            } catch (error) {
                console.error('Ошибка при удалении товара:', error);
            }
        }
    };

    const handleModalClose = () => {
        setIsModalOpen(false);
        fetchProducts(); // Обновляем список товаров после закрытия модального окна
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const productData = { name, price };

        try {
            if (selectedProduct) {
                // Редактирование товара
                await axios.put(`/api/products/${selectedProduct.id}`, productData);
            } else {
                // Добавление нового товара
                await axios.post('/api/products', productData);
            }
            handleModalClose();
        } catch (error) {
            console.error('Ошибка при сохранении товара:', error);
        }
    };

    return (
        <div>
            <h2>Управление товарами</h2>
            <button onClick={handleAddProduct}>Добавить товар</button>

            <table>
                <thead>
                <tr>
                    <th>Название</th>
                    <th>Цена</th>
                    <th>Действия</th>
                </tr>
                </thead>
                <tbody>
                {products.map(product => (
                    <tr key={product.id}>
                        <td>{product.name}</td>
                        <td>{product.price}</td>
                        <td>
                            <button onClick={() => handleEditProduct(product)}>Редактировать</button>
                            <button onClick={() => handleDeleteProduct(product.id)}>Удалить</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>

            {isModalOpen && (
                <div className="modal">
                    <h2>{selectedProduct ? 'Редактировать товар' : 'Добавить товар'}</h2>
                    <form onSubmit={handleSubmit}>
                        <div>
                            <label>Название:</label>
                            <input
                                type="text"
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                                required
                            />
                        </div>
                        <div>
                            <label>Цена:</label>
                            <input
                                type="number"
                                value={price}
                                onChange={(e) => setPrice(e.target.value)}
                                required
                            />
                        </div>
                        <button type="submit">{selectedProduct ? 'Сохранить' : 'Добавить'}</button>
                        <button type="button" onClick={handleModalClose}>Закрыть</button>
                    </form>
                </div>
            )}
        </div>
    );
};

export default ProductManagementPage;
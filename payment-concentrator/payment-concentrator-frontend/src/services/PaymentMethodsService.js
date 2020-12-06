const getAll = () =>
    fetch("http://localhost:8081/api/auth/payment-method", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + localStorage.getItem("token")
        }
    })
        .then(response => response.json())
        .catch((error) => {
            console.error('Error:', error);
        });

const getAllWithoutFirstThree = () =>
    fetch("http://localhost:8081/api/auth/payment-method/other", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + localStorage.getItem("token")
        }
    })
        .then(response => response.json())
        .catch((error) => {
            console.error('Error:', error);
        });

const service = {
    getAll,
    getAllWithoutFirstThree
}
export default service;
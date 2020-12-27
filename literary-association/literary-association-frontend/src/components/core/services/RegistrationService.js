const getFormFields = () =>
    fetch('http://localhost:8080/api/auth/form-fields/user-input-details', {
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
        }
    })
        .then(response => response.json())
        .catch((error) => {
            console.error('Error:', error)
        });

const service = {
    getFormFields
}

export default service;
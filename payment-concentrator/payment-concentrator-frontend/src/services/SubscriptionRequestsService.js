const createRequest = (request) =>
    fetch("http://localhost:8081/api/auth/subscribe", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(request)
    })
        .then(response => response.json())
        .catch((error) => {
            console.error('Error:', error);
        });


const service = {
    createRequest
}

export default service;
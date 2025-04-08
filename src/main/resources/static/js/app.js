let currentPage = 0;
let totalPages = 0;
const pageSize = 10;

document.getElementById('searchForm').addEventListener('submit', function(e) {
    e.preventDefault();
    currentPage = 0;
    fetchOffers();
});

document.getElementById('prevBtn').addEventListener('click', () => {
    if (currentPage > 0) {
        currentPage--;
        fetchOffers();
    }
});

document.getElementById('nextBtn').addEventListener('click', () => {
    if (currentPage < totalPages - 1) {
        currentPage++;
        fetchOffers();
    }
});

async function fetchOffers() {
    const from = document.getElementById('fromCity').value;
    const to = document.getElementById('toCity').value;

    toggleLoading(true);

    try {
        const response = await fetch(`/api/search?fromCity=${encodeURIComponent(from)}&toCity=${encodeURIComponent(to)}&page=${currentPage}&size=${pageSize}`);
        const data = await response.json();

        renderOffers(data.content);
        updatePagination(data);
    } catch (error) {
        console.error('Error:', error);
        showError();
    } finally {
        toggleLoading(false);
    }
}

function renderOffers(offers) {
    const resultsDiv = document.getElementById('results');
    resultsDiv.innerHTML = '';

    offers.forEach(offer => {
        const card = document.createElement('div');
        card.className = 'col-md-6 col-lg-4';
        card.innerHTML = `
            <div class="offer-card card h-100 position-relative">
                <span class="price-badge badge rounded-pill">$${offer.price}</span>
                <img src="https://source.unsplash.com/random/400x300/?${encodeURIComponent(offer.toCity)},travel"
                     class="card-img-top"
                     alt="${offer.toCity}"
                     loading="lazy">
                <div class="card-body">
                    <h5 class="card-title">${offer.fromCity} ➔ ${offer.toCity}</h5>
                    <div class="card-text">
                        <p class="text-muted">
                            <i class="bi bi-building"></i> ${offer.hotelName}
                        </p>
                        <div class="d-grid">
                            <button class="btn btn-outline-warning">احجز الآن</button>
                        </div>
                    </div>
                </div>
            </div>`;
        resultsDiv.appendChild(card);
    });
}

function updatePagination(data) {
    totalPages = data.totalPages;
    document.getElementById('pageInfo').innerText = `الصفحة ${currentPage + 1} من ${totalPages}`;
    document.getElementById('prevBtn').disabled = currentPage === 0;
    document.getElementById('nextBtn').disabled = currentPage === totalPages - 1;
}

function toggleLoading(isLoading) {
    document.querySelectorAll('button').forEach(btn => btn.disabled = isLoading);
    document.getElementById('pagination').classList.toggle('opacity-50', isLoading);
}

function showError() {
    document.getElementById('results').innerHTML = `
        <div class="col-12 text-center py-5">
            <h3 class="text-danger">حدث خطأ أثناء جلب البيانات</h3>
            <button class="btn btn-outline-danger mt-3" onclick="fetchOffers()">إعادة المحاولة</button>
        </div>`;
}
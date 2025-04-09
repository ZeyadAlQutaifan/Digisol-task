let allOffers = [];
let currentPage = 1;
const pageSize = 6;

document.getElementById('searchForm').addEventListener('submit', function (e) {
    e.preventDefault();
    const from = document.getElementById('fromCity').value;
    const to = document.getElementById('toCity').value;

    // Show loading state
    const searchBtn = this.querySelector('button');
    searchBtn.innerHTML = '<span class="spinner-border spinner-border-sm"></span> Searching...';
    searchBtn.disabled = true;

    fetch(`/search?fromCity=${encodeURIComponent(from)}&toCity=${encodeURIComponent(to)}`)
        .then(res => res.json())
        .then(data => {
            allOffers = data;
            currentPage = 1;
            renderPage();
            document.getElementById('pagination').classList.toggle('d-none', data.length <= pageSize);
            searchBtn.innerHTML = '<i class="bi bi-search"></i> Search';
            searchBtn.disabled = false;
        })
        .catch(error => {
            console.error('Error:', error);
            searchBtn.innerHTML = '<i class="bi bi-search"></i> Search';
            searchBtn.disabled = false;
        });
});

function renderPage() {
    const start = (currentPage - 1) * pageSize;
    const end = start + pageSize;
    const paginatedOffers = allOffers.slice(start, end);

    const resultsDiv = document.getElementById('results');
    resultsDiv.innerHTML = '';

    if (paginatedOffers.length === 0) {
        resultsDiv.innerHTML = `
                <div class="col-12 text-center py-5">
                    <h3 class="text-muted">No results found</h3>
                    <p class="text-muted">Try adjusting your search criteria</p>
                </div>`;
        return;
    }

    paginatedOffers.forEach(offer => {
        const card = document.createElement('div');
        card.className = 'col-md-6 col-lg-4';
        card.innerHTML = `
<div class="offer-card card h-100 position-relative">
    <span class="price-badge badge rounded-pill">${offer.percentSavings}% off</span>
    <img src="${offer.hotelImageUrl}" class="card-img-top hotel-image" alt="${offer.toCity}">

    <div class="card-body">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h5 class="card-title m-0">${offer.fromCity} ➔ ${offer.toCity}</h5>
            <img src="${offer.flightDealCarrierImageUrl}"
                 alt="${offer.flightDealCarrier}"
                 style="height: 30px;">
        </div>

        <div class="hotel-rating mb-3">
            <span class="stars">${'★'.repeat(Math.floor(offer.hotelStarRating))}</span>
            <small class="text-muted">(${offer.hotelGuestReviewRating} rating)</small>
        </div>

        <div class="row g-2 mb-3">
            <div class="col-6">
                <div class="bg-light p-2 rounded text-center">
                    <small class="text-muted d-block">Departure Date</small>
                    <strong>${offer.formattedTravelStartDate}</strong>
                </div>
            </div>
            <div class="col-6">
                <div class="bg-light p-2 rounded text-center">
                    <small class="text-muted d-block">Return Date</small>
                    <strong>${offer.formattedTravelEndDate}</strong>
                </div>
            </div>
        </div>

        <div class="pricing-info">
            <table class="table table-sm">
                <tr>
                    <td>Price per person:</td>
                    <td class="text-end">${offer.formattedPerPassengerPackagePrice}</td>
                </tr>
                <tr>
                    <td>Total price:</td>
                    <td class="text-end">${offer.formattedTotalPriceValue}</td>
                </tr>
                <tr class="table-success">
                    <td>You save:</td>
                    <td class="text-end">${offer.formattedTotalSavings}</td>
                </tr>
            </table>
        </div>

        <div class="d-grid gap-2">
            <button class="btn btn-warning">Book Now</button>
            <button class="btn btn-outline-secondary btn-sm">
                <i class="bi bi-info-circle"></i> Details
            </button>
        </div>
    </div>
</div>`;
        resultsDiv.appendChild(card);
    });

    document.getElementById('pageNumber').innerText = currentPage;
    updatePaginationButtons();
}

function prevPage() {
    if (currentPage > 1) {
        currentPage--;
        renderPage();
    }
}

function nextPage() {
    if ((currentPage * pageSize) < allOffers.length) {
        currentPage++;
        renderPage();
    }
}

function updatePaginationButtons() {
    const prevBtn = document.querySelector('.page-item:first-child .page-link');
    const nextBtn = document.querySelector('.page-item:last-child .page-link');

    prevBtn.disabled = currentPage === 1;
    nextBtn.disabled = (currentPage * pageSize) >= allOffers.length;
}
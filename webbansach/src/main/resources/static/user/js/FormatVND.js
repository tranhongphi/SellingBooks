function formatToVND(N) {
    const test1 = N;
    const format = test1.replace(/\B(?=(\d{3})+(?!\d))/g, ',')
    return N;
}
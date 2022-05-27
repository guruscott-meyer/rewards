import logo from './logo.svg';
import './App.css';

function App() {
    let totalRewards = 0;

    let transactions = [
            {
            customerId: "100",
            month: "JANUARY",
            total: 45.00
            },
            {
            customerId: "100",
            month: "JANUARY",
            total: 51.00
            },
            {
            customerId: "100",
            month: "JANUARY",
            total: 101.00
            },
            {
            customerId: "200",
            month: "JANUARY",
            total: 45.00
            },
            {
            customerId: "100",
            month: "FEBRUARY",
            total: 100.00
            },
            {
            customerId: "100",
            month: "JANUARY",
            total: 300.00
            }
          ];

    fetch("http://localhost:8080/rewards?customerId=100&month=JANUARY", {
            method: 'POST',
            headers: {
              'Content-Type': 'application/JSON',
              'Access-Control-Allow-Origin': 'true'
            },
            body: JSON.stringify(transactions)
          })
          .then(res => res.json())
          .then(
            (result) => {
                totalRewards = result;
            });
  return (
    <div className="App">
      <header className="App-header">
        <p>
          Rewards Total = {totalRewards}
        </p>
      </header>
    </div>
  );
}

export default App;

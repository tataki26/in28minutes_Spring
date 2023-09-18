export default function CounterResetButton({resetMethod}) {
    return (
        <div className="Counter">
            <button className="counterResetButton"
                onClick={resetMethod}
                >reset</button>
        </div>
    )
}
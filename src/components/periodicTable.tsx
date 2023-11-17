import { FC } from 'react';
import '../styles/periodicTable.styles.css';

interface Props {
  element: string;
}

const PeriodicTable: FC<Props> = ({ element }) => (
  <div className="periodic-table-container">
    <div className="periodic-element">
      <h2 className="element-symbol">{element}</h2>
    </div>
  </div>
);

export default PeriodicTable;

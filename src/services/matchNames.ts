interface IBody {
  firstName: string;
  lastName: string;
}

export const matchNames = async (body: IBody) => {
  try {
    const res = await fetch('http://localhost:8080/api/highlight-elements', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(body),
    });
    const result = await res.json();
    return result;
  } catch (error) {
    return error;
  }
};

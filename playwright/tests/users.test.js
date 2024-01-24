// @ts-check
const { test, expect } = require('@playwright/test');

test('test', async ({ request }) => {
  const response = await request.get('/users');

  expect(response.ok()).toBeTruthy();

  const body = await response.json();

  expect(body.msg).toBe('Hello, world!');
});

test('retrieve user', async ({ request }) => {
  const response = await request.get('/users/3');

  expect(response.ok()).toBeTruthy();

  const body = await response.json();

  expect(body.id).toBe(3);
  expect(body.firstName).toBe('John');
  expect(body.lastName).toBe('Doe');
  expect(body.age).toBe(35);
  expect(body.weight).toBe(185.3);
});

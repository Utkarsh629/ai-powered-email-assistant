console.log("Email Writer loaded");

function getEmailContent() {
  const selectors = [
    '.h7',
    '.a3s.aiL',
    '.gmail_quote',
    '[role="presentation"]'
  ];

  for (const selector of selectors) {
    const content = document.querySelector(selector);
    if (content) {
      return content.innerText.trim();
    }
  }
  return '';
}

function findComposeToolbar() {
  const selectors = ['.btC', '.aDh', '.gU.Up'];

  for (const selector of selectors) {
    const toolbar = document.querySelector(selector);
    if (toolbar) return toolbar;
  }
  return null;
}

function createAIButton() {
  const button = document.createElement('div');
  button.className = 'T-I J-J5-Ji aoO v7 T-I-atl L3 ai-reply-button';
  button.style.marginRight = '8px';
  button.innerText = 'AI Reply';
  button.setAttribute('role', 'button');
  button.setAttribute('data-tooltip', 'Generate AI Reply');
  return button;
}

function injectButton() {
  const toolbar = findComposeToolbar();
  if (!toolbar) return;

  if (toolbar.querySelector('.ai-reply-button')) return;

  const button = createAIButton();

  button.addEventListener('click', async () => {
    try {
      button.innerText = 'Generating...';
      button.style.pointerEvents = 'none';
      button.style.opacity = '0.6';

      const emailContent = getEmailContent();
      if (!emailContent) throw new Error("No email content found");

      const response = await fetch('http://localhost:8080/api/email/generate', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          emailContent,
          tone: 'professional'
        })
      });

      if (!response.ok) throw new Error('API request failed');

      const generatedReply = await response.text();

      const composeBox = document.querySelector(
        '[role="textbox"][g_editable="true"]'
      );

      if (composeBox) {
        composeBox.focus();
        document.execCommand('insertText', false, generatedReply);
      }
    } catch (err) {
      console.error(err);
      alert('Failed to generate reply');
    } finally {
      button.innerText = 'AI Reply';
      button.style.pointerEvents = 'auto';
      button.style.opacity = '1';
    }
  });

  toolbar.insertBefore(button, toolbar.firstChild);
}

const observer = new MutationObserver(() => {
  injectButton();
});

observer.observe(document.body, {
  childList: true,
  subtree: true
});
